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
public class CPDouble extends CPBase {
    double bytes;
    CPDouble(ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        bytes = dis.readDouble();
    }

    @Override
    public int getType() {
        return 6;
    }

    @Override
    public boolean verify() {
        return true;
    }
}
