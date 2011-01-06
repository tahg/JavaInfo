/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disasm;

/**
 *
 * @author Nathan
 */
public class UnaryOp extends Instruction {

    int op;

    public UnaryOp(int offset, int op) {
        super(offset);
        this.op = op;
    }
}
