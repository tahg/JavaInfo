/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package disasm;

/**
 *
 * @author Nathan
 */
public class NewArray extends Instruction {
    int type;
    NewArray(int offset, int type) {
        super(offset);
        this.type = type;
    }
}
