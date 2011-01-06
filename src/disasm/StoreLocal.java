/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package disasm;

/**
 *
 * @author Nathan
 */
public class StoreLocal extends Instruction {
    int index;

    public StoreLocal(int offset, int index) {
        super(offset);
        this.index = index;
    }    
}
