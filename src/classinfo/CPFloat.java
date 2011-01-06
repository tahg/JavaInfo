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
public class CPFloat extends CPBase {
    float bytes;
    CPFloat(ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        bytes = dis.readFloat();
    }

    @Override
    public int getType() {
        return 4;
    }

    @Override
    public boolean verify() {
        return true;
    }
}
