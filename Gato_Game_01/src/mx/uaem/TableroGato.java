/*
 * Copyright (C) 2011 Rene Cruz Flores - CUX UAEMex <rgcruzf@uaemex.mx>
 * http://cux.uaemex.mx/~renecruz
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
package mx.uaem;

/**
 *
 * @author Rene Cruz Flores - CUX UAEMex (2011)
 */
public class TableroGato {
    
    private char[][] tablero;
    
    public TableroGato() {
        tablero = new char[3][3];
        initTablero();
    }
    
    public void initTablero() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                tablero[row][col] = ' ';
            }
            
        }
    }
    
    public int checkGato() {
        int estado = 0; //0 = sigue el juego, 1 = gano X, 2 = gano O, 3 = gato lleno
        for (int row = 0; row < 3; row++) {
            if (tablero[row][0] == 'X' && tablero[row][1] == 'X' && tablero[row][2] == 'X') {
                return 1;
            }
            if (tablero[row][0] == 'O' && tablero[row][1] == 'O' && tablero[row][2] == 'O') {
                return 2;
            }
        }
        
        for (int col = 0; col < 3; col++) {
            if (tablero[0][col] == 'X' && tablero[1][col] == 'X' && tablero[2][col] == 'X') {
                return 1;
            }
            if (tablero[0][col] == 'O' && tablero[1][col] == 'O' && tablero[2][col] == 'O') {
                return 2;
            }
        }

        //Primer diagonal
        if (tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == 'X') {
            return 1;
        }
        if (tablero[0][0] == 'O' && tablero[1][1] == 'O' && tablero[2][2] == 'O') {
            return 2;
        }
        //Segunda diagonal
        if (tablero[2][0] == 'X' && tablero[1][1] == 'X' && tablero[0][2] == 'X') {
            return 1;
        }
        if (tablero[2][0] == 'O' && tablero[1][1] == 'O' && tablero[0][2] == 'O') {
            return 2;
        }
        
        return 0;
    }
    
    public boolean hacerTirada(char simbol, int row, int col) {
        if (tablero[row][col] == ' ') {
            tablero[row][col] = simbol;
            System.out.println("Tirada de: " + simbol + " en: " + row + ", " + col);
            return true;
        }
        return false;
        
    }
    
    @Override
    public String toString() {
        StringBuffer cadena = new StringBuffer();
        
        cadena.append("+-+-+-+\n");
        for (int row = 0; row < 3; row++) {
            cadena.append("|");
            for (int col = 0; col < 3; col++) {
                cadena.append(tablero[row][col] + "|");
            }
            cadena.append("\n+-+-+-+\n");
        }
        
        return cadena.toString();
    }
}
