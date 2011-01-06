/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javainfo;

import classinfo.ClassFile;
import classinfo.MethodInfo;
import disasm.Disassembler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.*;
import javax.swing.JFileChooser;

/**
 *
 * @author Nathan
 */
public class JavaInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.JFileChooser open = new JFileChooser();
        open.setCurrentDirectory(new File("D:/Nathan/Minecraft"));
        open.showOpenDialog(null);
        File fin = open.getSelectedFile();
        if(fin == null) return;
        try {
            ZipFile file = new ZipFile(fin);
            Disassembler d = new Disassembler();
            Enumeration<? extends ZipEntry> entries = file.entries();
            while(entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if(entry.getName().endsWith(".class")) {
                    System.err.println("Reading class: " + entry.getName());
                    InputStream stream = file.getInputStream(entry);
                    ClassFile classFile = new ClassFile(stream);
                    MethodInfo[] methods = classFile.getMethods();
                    int i = 0;
                    for(MethodInfo m : methods) {
                        d.disassemble(m.getCode(), classFile);
                        i++;
                    }
                    int avail = stream.available();
                    if(avail > 0)
                        System.err.println(entry.getName() + " " + avail);
                }
            }
            file.close();
        } catch (IOException ex) {
        }
    }
}
