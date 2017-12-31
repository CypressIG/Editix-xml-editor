package com.japisoft.editix.action.file.imp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.japisoft.editix.ui.EditixFactory;

/**
This program is available under two licenses : 

1. For non commercial usage : 

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

2. For commercial usage :

You need to get a commercial license for source usage at : 

http://www.editix.com/buy.html

Copyright (c) 2018 Alexandre Brillant - JAPISOFT SARL - http://www.japisoft.com

@author Alexandre Brillant - abrillant@japisoft.com
@author JAPISOFT SARL - http://www.japisoft.com

*/
public class CSVPanel extends JPanel implements ActionListener {

  public CSVPanel() {
	  initComponents();
	  spStartingRow.setValue( 1 );
	  lstColumnName.setModel( new DefaultListModel() );
  }

  public void addNotify() {
  	super.addNotify();
  	btnColumnAdd.addActionListener( this );
  	btnColumnRemove.addActionListener( this );
  	cbOther.addActionListener( this );
  }

  public void removeNotify() {
  	super.removeNotify();
  	btnColumnAdd.removeActionListener( this );
  	btnColumnRemove.removeActionListener( this );
  	cbOther.removeActionListener( this );
  }

  public String getRowName() {
	  return tfRow.getText();
  }
  
  public boolean hasRowNumber() {
	  return cbRowNumber.isSelected();
  }
  
  public boolean convertColToElement() {
	  return cbConvertColToElement.isSelected();
  }

  public String getColName( int index, String defaultName ) {
	  if ( index < lstColumnName.getModel().getSize() ) {
		  return ( String )lstColumnName.getModel().getElementAt( index );
	  } else
		  return defaultName;
  }

  public int getStartingRow() {
	  return ( Integer )spStartingRow.getValue();
  }

  public char getStringDelimiter() {
	char chrDelim = 0;
	if ( cbTextQualifier.getSelectedIndex() > 0)
		chrDelim = ( (String)cbTextQualifier.getSelectedItem() ).charAt( 0 );
	return chrDelim;
  }

  public char getSeparator() {
		char sep = ',';
		if ( cbArobas.isSelected() )
			sep = '@';
		else
		if ( cbDash.isSelected() ) 
			sep = '-';
		else
		if ( cbDoubleDot.isSelected() )
			sep = ':';
		else
		if ( cbExclamationMark.isSelected() )
			sep = '!';
		else
		if ( cbSlash.isSelected() )
			sep = '/';
		else
		if ( cbVerticalBar.isSelected() )
			sep = '|';
		else
		if ( cbSemiColon.isSelected() )
			sep = ';';
		else 
		if ( cbSpace.isSelected() )
			sep = ' ';
		else 
		if ( cbTab.isSelected() )
			sep = '\t';
		else 
		if ( cbOther.isSelected() ) {
			if ( tfOther.getText() != null
					&& tfOther.getText().length() > 0)
				sep = tfOther.getText().charAt( 0 );
		}
		return sep;
  }

  public void actionPerformed( ActionEvent e ) {
  	if ( e.getSource() == btnColumnAdd ) {
  		String col = EditixFactory.buildAndShowInputDialog( "Column name ?" );
  		if ( col != null && !"".equals( col ) )
  			((DefaultListModel)lstColumnName.getModel()).addElement( col );
  	} else 
  	if ( e.getSource() == btnColumnRemove ) {
  		if ( lstColumnName.getSelectedIndex() != -1 ) {
  			((DefaultListModel)lstColumnName.getModel()).remove( lstColumnName.getSelectedIndex() );
  		}
  	} else
  	if ( e.getSource() == cbOther ) {
  		tfOther.setEnabled( cbOther.isSelected() );
  	}
  }  
  
  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">
  private void initComponents() {

      buttonGroup1 = new javax.swing.ButtonGroup();
      jPanel1 = new javax.swing.JPanel();
      cbTab = new javax.swing.JRadioButton();
      cbSemiColon = new javax.swing.JRadioButton();
      cbComma = new javax.swing.JRadioButton();
      cbSpace = new javax.swing.JRadioButton();
      cbVerticalBar = new javax.swing.JRadioButton();
      cbDoubleDot = new javax.swing.JRadioButton();
      cbDash = new javax.swing.JRadioButton();
      cbSlash = new javax.swing.JRadioButton();
      cbExclamationMark = new javax.swing.JRadioButton();
      cbArobas = new javax.swing.JRadioButton();
      cbOther = new javax.swing.JRadioButton();
      tfOther = new javax.swing.JTextField();
      jLabel1 = new javax.swing.JLabel();
      cbTextQualifier = new javax.swing.JComboBox();
      jLabel2 = new javax.swing.JLabel();
      spStartingRow = new javax.swing.JSpinner();
      jSeparator1 = new javax.swing.JSeparator();
      jLabel3 = new javax.swing.JLabel();
      spColumnName = new javax.swing.JScrollPane();
      lstColumnName = new javax.swing.JList();
      btnColumnAdd = new javax.swing.JButton();
      btnColumnRemove = new javax.swing.JButton();
      cbConvertColToElement = new javax.swing.JCheckBox();
      jSeparator2 = new javax.swing.JSeparator();
      jLabel4 = new javax.swing.JLabel();
      tfRow = new javax.swing.JTextField();
      cbRowNumber = new javax.swing.JCheckBox();

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Delimiters"));

      buttonGroup1.add(cbTab);
      cbTab.setText("Tab");

      buttonGroup1.add(cbSemiColon);
      cbSemiColon.setText("SemiColon");

      buttonGroup1.add(cbComma);
      cbComma.setSelected(true);
      cbComma.setText("Comma");

      buttonGroup1.add(cbSpace);
      cbSpace.setText("Space");

      buttonGroup1.add(cbVerticalBar);
      cbVerticalBar.setText("Vertical bar");

      buttonGroup1.add(cbDoubleDot);
      cbDoubleDot.setText("Double dot");

      buttonGroup1.add(cbDash);
      cbDash.setText("Dash");

      buttonGroup1.add(cbSlash);
      cbSlash.setText("Slash");

      buttonGroup1.add(cbExclamationMark);
      cbExclamationMark.setText("Exclamation mark");

      buttonGroup1.add(cbArobas);
      cbArobas.setText("Arobas");

      buttonGroup1.add(cbOther);
      cbOther.setText("Other :");

      org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
          jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
          .add(jPanel1Layout.createSequentialGroup()
              .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                  .add(jPanel1Layout.createSequentialGroup()
                      .add(cbTab)
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                      .add(cbSemiColon)
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                      .add(cbComma)
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                      .add(cbSpace)
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                      .add(cbVerticalBar))
                  .add(jPanel1Layout.createSequentialGroup()
                      .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                          .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                              .add(cbOther)
                              .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                              .add(tfOther))
                          .add(org.jdesktop.layout.GroupLayout.LEADING, cbDoubleDot))
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                      .add(cbDash)
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                      .add(cbSlash)
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                      .add(cbExclamationMark)
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                      .add(cbArobas)))
              .addContainerGap(15, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
          jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
          .add(jPanel1Layout.createSequentialGroup()
              .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                  .add(cbTab)
                  .add(cbSemiColon)
                  .add(cbComma)
                  .add(cbSpace)
                  .add(cbVerticalBar))
              .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
              .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                  .add(cbDoubleDot)
                  .add(cbDash)
                  .add(cbSlash)
                  .add(cbExclamationMark)
                  .add(cbArobas))
              .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
              .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                  .add(cbOther)
                  .add(tfOther, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
              .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jLabel1.setText("Text Qualifier");

      cbTextQualifier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "\"", "'" }));

      jLabel2.setText("Starting row");

      jLabel3.setText("Column name");

      spColumnName.setViewportView(lstColumnName);

      btnColumnAdd.setText("Add");

      btnColumnRemove.setText("Remove");

      cbConvertColToElement.setText("Convert column to element");

      jLabel4.setText("Row name");

      tfRow.setText("row");

      cbRowNumber.setText("Row number");

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
          .add(layout.createSequentialGroup()
              .addContainerGap()
              .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                  .add(org.jdesktop.layout.GroupLayout.TRAILING, jSeparator2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                  .add(spColumnName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                  .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                  .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                      .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      .add(layout.createSequentialGroup()
                          .add(jLabel1)
                          .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                          .add(cbTextQualifier, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 76, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                          .add(jLabel2)
                          .add(18, 18, 18)
                          .add(spStartingRow, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                  .add(jLabel3)
                  .add(layout.createSequentialGroup()
                      .add(btnColumnAdd)
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                      .add(btnColumnRemove)
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 91, Short.MAX_VALUE)
                      .add(cbConvertColToElement))
                  .add(jLabel4)
                  .add(layout.createSequentialGroup()
                      .add(tfRow, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 198, Short.MAX_VALUE)
                      .add(cbRowNumber)))
              .addContainerGap())
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
          .add(layout.createSequentialGroup()
              .addContainerGap()
              .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
              .add(18, 18, 18)
              .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                  .add(jLabel1)
                  .add(cbTextQualifier, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .add(spStartingRow, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .add(jLabel2))
              .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
              .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
              .add(jLabel3)
              .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
              .add(spColumnName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
              .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                  .add(btnColumnAdd)
                  .add(btnColumnRemove)
                  .add(cbConvertColToElement))
              .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
              .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
              .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                  .add(layout.createSequentialGroup()
                      .add(jLabel4)
                      .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                      .add(tfRow, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                  .add(cbRowNumber))
              .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
  }// </editor-fold>


  // Variables declaration - do not modify
  private javax.swing.JButton btnColumnAdd;
  private javax.swing.JButton btnColumnRemove;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JRadioButton cbArobas;
  private javax.swing.JRadioButton cbComma;
  private javax.swing.JCheckBox cbConvertColToElement;
  private javax.swing.JRadioButton cbDash;
  private javax.swing.JRadioButton cbDoubleDot;
  private javax.swing.JRadioButton cbExclamationMark;
  private javax.swing.JRadioButton cbOther;
  private javax.swing.JCheckBox cbRowNumber;
  private javax.swing.JRadioButton cbSemiColon;
  private javax.swing.JRadioButton cbSlash;
  private javax.swing.JRadioButton cbSpace;
  private javax.swing.JRadioButton cbTab;
  private javax.swing.JComboBox cbTextQualifier;
  private javax.swing.JRadioButton cbVerticalBar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JList lstColumnName;
  private javax.swing.JScrollPane spColumnName;
  private javax.swing.JSpinner spStartingRow;
  private javax.swing.JTextField tfOther;
  private javax.swing.JTextField tfRow;
  // End of variables declaration
  
}