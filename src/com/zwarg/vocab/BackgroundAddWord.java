/**
 * BackgroundAddWord.java
 * 
 * Copyright (c) 2002 David Zwarg <david.zwarg@gmail.com>
 * See LICENSE in the project root for copying permission.
 */
package com.zwarg.vocab;

import com.zwarg.vocab.XMLUtils;

import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.JLabel;

/**
 * 
 * @author davidz
 * @version 1.0
 */
public class BackgroundAddWord implements Runnable {
  boolean bolRunning = false;
  int intDef = 0;
  XMLUtils xmlDoc;
  String strWord;
  String[] strDefs;
  JProgressBar prgProgress;

  public BackgroundAddWord( XMLUtils doc ) {
    this.xmlDoc = doc;
  }

  public void setWord( String word ) {
    this.strWord = word;
  }

  public void setDefinitions( String[] defs ) {
    this.strDefs = defs;
  }

  public void run() {
    Component[] comp = prgProgress.getParent().getComponents();
    JLabel tmp = new JLabel();

    for ( int i = 0; i < comp.length; i ++ )
      if ( comp[i] instanceof JLabel )
        tmp = (JLabel)comp[i];

    if ( strDefs != null ) {
      if ( this.prgProgress != null )
        prgProgress.setMaximum( strDefs.length );

      for ( int i = 0; i < strDefs.length; i++ ) {
        tmp.setText( "Adding word and definition..." );

        this.xmlDoc.addXMLNode( this.strWord, strDefs[i] );

        if ( this.prgProgress != null )
          prgProgress.setValue( i + 1 );
      }

      try { Thread.sleep(500); }
      catch (InterruptedException e ){}
    }

    if ( this.prgProgress != null )
      this.prgProgress.setValue( 0 );

    tmp.setText( " " );

    this.bolRunning = false;
  }

  public void start() {
    this.bolRunning = true;

    new Thread( this ).start();
  }

  public boolean isRunning () {
    return this.bolRunning;
  }

  public int getProgress() {
    return this.intDef;
  }

  public void setProgressBar( JProgressBar progress ) {
    this.prgProgress = progress;
  }
}