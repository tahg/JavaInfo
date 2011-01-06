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
public class CPInteger extends CPBase {
    int bytes;
    CPInteger(ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        bytes = dis.readInt();
    }

    @Override
    public int getType() {
        return 3;
    }

    @Override
    public boolean verify() {
        return true;
    }
}
