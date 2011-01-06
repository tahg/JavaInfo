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
public class CPLong extends CPBase {
    long bytes;
    CPLong(ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        bytes = dis.readLong();
    }

    @Override
    public int getType() {
        return 5;
    }

    @Override
    public boolean verify() {
        return true;
    }
}
