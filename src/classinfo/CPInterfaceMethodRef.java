/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classinfo;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Nathan
 */
public class CPInterfaceMethodRef extends CPRef {

    CPInterfaceMethodRef(ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp, dis);
    }

    @Override
    public int getType() {
        return 11;
    }
}
