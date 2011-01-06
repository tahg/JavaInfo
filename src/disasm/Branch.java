/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package disasm;

/**
 *
 * @author Nathan
 */
public class Branch extends Instruction {

    int type, delta;
    Branch(int offset, int type, int delta) {
        super(offset);
        this.type = type;
        this.delta = delta;
    }

}
