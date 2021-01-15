/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_01_tema04_ed;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author francis
 */
public class Ejercicio_01_Tema04_ED 
{
    private static byte[] intermedio = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream entradaStream = null;
    private static BufferedInputStream entradaBuffer = null;

    public static void iniciacionArchivos() throws FileNotFoundException
    {
        entradaStream = new FileInputStream(nombreArchivo);
        entradaBuffer = new BufferedInputStream(entradaStream);
    }
    
    public static int mostrarArchivoTexto() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = entradaStream.read(intermedio)) != -1) 
        {
            System.out.println(new String(intermedio));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            iniciacionArchivos();
            
            int total = mostrarArchivoTexto();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( entradaBuffer != null && entradaStream != null )
                {
                    entradaStream.close();
                    entradaBuffer.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
