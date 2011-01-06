/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package disasm;

/**
 *
 * @author Nathan
 */
public class Cast extends Instruction {
    int index;

    public Cast(int offset, int index) {
        super(offset);
        this.index = index;
    }
    
}
