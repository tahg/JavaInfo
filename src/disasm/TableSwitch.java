/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package disasm;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Nathan
 */
public class TableSwitch extends Instruction {
    int def, low, high;
    int[] table;
    public TableSwitch(int offset, DataInputStream dis) throws IOException {
        super(offset);
        def = dis.readInt();
        low = dis.readInt();
        high = dis.readInt();
        int count = high - low + 1;
        table = new int[count];
        for(int i = 0; i < count; i++) {
            table[i] = dis.readInt();
        }
    }
    

}
