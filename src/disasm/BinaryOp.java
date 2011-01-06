/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disasm;

/**
 *
 * @author Nathan
 */
public class BinaryOp extends Instruction {

    int op;

    public BinaryOp(int offset, int op) {
        super(offset);
        this.op = op;
    }
}
