/*
 * Copyright 2014 Pompeu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.solutions.pompeu.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pompeu
 */
public class ModeloTabelaCartao extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;

    public ModeloTabelaCartao(ArrayList dados, String[] col) {
        setLinhas(dados);
        setColunas(col);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    private void setLinhas(ArrayList list) {
        linhas = list;
    }

    public String[] getColunas() {
        return colunas;
    }

    private void setColunas(String[] strings) {
        colunas = strings;
    }

    @Override
    public int getRowCount() {
        return getLinhas().size();
    }

    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] linha = (Object[]) getLinhas().get(rowIndex);
        return linha[columnIndex];
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Código";
            case 1:
                return "SALDO";
            
        }
        return null;
    }

}
