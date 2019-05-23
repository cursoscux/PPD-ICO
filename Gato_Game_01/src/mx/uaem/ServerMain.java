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
public class ServerMain {
    public static void main(String[] args) {
        Servidor server = new Servidor("Rene Server");
        server.start();
        System.out.println("Server on-line");
    }
}
