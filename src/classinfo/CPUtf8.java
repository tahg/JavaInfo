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
public class CPUtf8 extends CPBase {
    String bytes;
    public CPUtf8(ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        bytes = dis.readUTF();
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public boolean verify() {
        return true;
    }

}
