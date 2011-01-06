/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disasm;

import classinfo.ClassFile;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nathan
 */
public class Disassembler {

    public Instruction[] disassemble(byte[] code, ClassFile cf) {
        ArrayList<Instruction> instructions = new ArrayList<Instruction>();
        int index;
        try {
            DataInputStream dis = new DataInputStream(new ByteArrayInputStream(code));
            while (dis.available() > 0) {
                index = code.length - dis.available();
                byte opcode = dis.readByte();
                switch (opcode) {
//<editor-fold desc="Load Constant (1-20)">
                    case 1:
                        instructions.add(new LoadConstant(index, null));
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        instructions.add(new LoadConstant(index, new Integer(opcode - 3)));
                        break;
                    case 9:
                    case 10:
                        instructions.add(new LoadConstant(index, new Long(opcode - 9)));
                        break;
                    case 11:
                    case 12:
                    case 13:
                        instructions.add(new LoadConstant(index, new Float(opcode - 11)));
                        break;
                    case 14:
                    case 15:
                        instructions.add(new LoadConstant(index, new Double(opcode - 14)));
                        break;
                    case 16:
                        instructions.add(new LoadConstant(index, new Integer(dis.readByte())));
                        break;
                    case 17:
                        instructions.add(new LoadConstant(index, new Integer(dis.readShort())));
                        break;
                    case 18:
                        instructions.add(new LoadConstantPool(index, dis.readUnsignedByte()));
                        break;
                    case 19:
                        instructions.add(new LoadConstantPool(index, dis.readUnsignedShort()));
                        break;
                    case 20:
                        instructions.add(new LoadConstantPool(index, dis.readUnsignedShort()));
                        break;
//</editor-fold>
//<editor-fold desc="Load (21-53)">
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        instructions.add(new LoadLocal(index, dis.readUnsignedByte()));
                        break;
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        //Load Int
                        instructions.add(new LoadLocal(index, opcode - 26));
                        break;
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                        //Load Long
                        instructions.add(new LoadLocal(index, opcode - 30));
                        break;
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                        //Load Float
                        instructions.add(new LoadLocal(index, opcode - 34));
                        break;
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                        //Load Double
                        instructions.add(new LoadLocal(index, opcode - 38));
                        break;
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                        //Load Ref
                        instructions.add(new LoadLocal(index, opcode - 42));
                        break;
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                        instructions.add(new LoadArray(index));
                        break;
//</editor-fold>
//<editor-fold desc="Store (54-86)">
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        instructions.add(new StoreLocal(index, dis.readUnsignedByte()));
                        break;
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                        //Store Int
                        instructions.add(new StoreLocal(index, opcode - 59));
                        break;
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                        //Store Long
                        instructions.add(new StoreLocal(index, opcode - 63));
                        break;
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                        //Store Float
                        instructions.add(new StoreLocal(index, opcode - 67));
                        break;
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                        //Store Double
                        instructions.add(new StoreLocal(index, opcode - 71));
                        break;
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                        //Store Ref
                        instructions.add(new StoreLocal(index, opcode - 75));
                        break;
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                        instructions.add(new StoreArray(index));
                        break;
//</editor-fold>
//<editor-fold desc="Stack (87-95)">
                    case 87:
                        instructions.add(new StackOp(index, 1, -1));
                        break;
                    case 88:
                        instructions.add(new StackOp(index, 2, -1));
                        break;
                    case 89:
                        instructions.add(new StackOp(index, 1, 0));
                        break;
                    case 90:
                        instructions.add(new StackOp(index, 1, 1));
                        break;
                    case 91:
                        instructions.add(new StackOp(index, 1, 2));
                        break;
                    case 92:
                        instructions.add(new StackOp(index, 2, 0));
                        break;
                    case 93:
                        instructions.add(new StackOp(index, 2, 1));
                        break;
                    case 94:
                        instructions.add(new StackOp(index, 2, 2));
                        break;
                    case 95:
                        instructions.add(new StackOp(index, 1, 3));
                        break;
//</editor-fold>
//<editor-fold desc="Operators (96--124)">
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                        instructions.add(new BinaryOp(index, 0));
                        break;
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                        instructions.add(new BinaryOp(index, 1));
                        break;
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                        instructions.add(new BinaryOp(index, 2));
                        break;
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                        instructions.add(new BinaryOp(index, 3));
                        break;
                    case 112:
                    case 113:
                    case 114:
                    case 115:
                        instructions.add(new BinaryOp(index, 4));
                        break;
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                        instructions.add(new UnaryOp(index, 0));
                        break;
                    case 120:
                    case 121:
                        instructions.add(new BinaryOp(index, 5));
                        break;
                    case 122:
                    case 123:
                        instructions.add(new BinaryOp(index, 6));
                        break;
                    case 124:
                    case 125:
                        instructions.add(new BinaryOp(index, 7));
                        break;
                    case 126:
                    case 127:
                        instructions.add(new BinaryOp(index, 8));
                        break;
                    case -128:
                    case -127:
                        instructions.add(new BinaryOp(index, 9));
                        break;
                    case -126:
                    case -125:
                        instructions.add(new BinaryOp(index, 10));
                        break;
                    case -124:
                        instructions.add(new Inc(index, dis.readUnsignedByte(), dis.readByte()));
                        break;
//</editor-fold>
//<editor-fold desc="Conversion (-123--109)">
                    case -123:
                        instructions.add(new X2l(index));
                        break;
                    case -122:
                        instructions.add(new X2f(index));
                        break;
                    case -121:
                        instructions.add(new X2d(index));
                        break;
                    case -120:
                        instructions.add(new X2i(index));
                        break;
                    case -119:
                        instructions.add(new X2f(index));
                        break;
                    case -118:
                        instructions.add(new X2d(index));
                        break;
                    case -117:
                        instructions.add(new X2i(index));
                        break;
                    case -116:
                        instructions.add(new X2l(index));
                        break;
                    case -115:
                        instructions.add(new X2d(index));
                        break;
                    case -114:
                        instructions.add(new X2i(index));
                        break;
                    case -113:
                        instructions.add(new X2l(index));
                        break;
                    case -112:
                        instructions.add(new X2f(index));
                        break;
                    case -111:
                        instructions.add(new X2b(index));
                        break;
                    case -110:
                        instructions.add(new X2c(index));
                        break;
                    case -109:
                        instructions.add(new X2s(index));
                        break;
//</editor-fold>
                    case -108:
                        instructions.add(new Compare(index));
                        break;
                    case -107:
                        instructions.add(new Compare(index));
                        break;
                    case -106:
                        instructions.add(new Compare(index));
                        break;
                    case -105:
                        instructions.add(new Compare(index));
                        break;
                    case -104:
                        instructions.add(new Compare(index));
                        break;
//<editor-fold desc="Branch (-103--89)">
                    case -103:
                    case -102:
                    case -101:
                    case -100:
                    case -99:
                    case -98:
                        instructions.add(new BranchZero(index, opcode + 103, dis.readShort()));
                        break;
                    case -97:
                    case -96:
                    case -95:
                    case -94:
                    case -93:
                    case -92:
                        instructions.add(new Branch(index, opcode + 97, dis.readShort()));
                        break;
                    case -91:
                    case -90:
                        instructions.add(new Branch(index, opcode + 91, dis.readShort()));
                        break;
                    case -89:
                        instructions.add(new BranchZero(index, 8, dis.readShort()));
                        break;
//</editor-fold>
//                    case -88:
//                    case -87:
                    case -86:
                        while (((code.length - dis.available()) % 4) != 0) {
                            dis.read();
                        }
                        instructions.add(new TableSwitch(index, dis));
                        break;
//                    case -85:
//                        break;
                    case -84:
                    case -83:
                    case -82:
                    case -81:
                    case -80:
                        instructions.add(new ReturnValue(index));
                        break;
                    case -79:
                        instructions.add(new Return(index));
                        break;
                    case -78:
                        instructions.add(new GetMember(index, dis.readUnsignedShort()));
                        break;
                    case -77:
                        instructions.add(new PutMember(index, dis.readUnsignedShort()));
                        break;
                    case -76:
                        instructions.add(new GetMember(index, dis.readUnsignedShort()));
                        break;
                    case -75:
                        instructions.add(new PutMember(index, dis.readUnsignedShort()));
                        break;
                    case -74:
                        instructions.add(new InvokeVirtual(index, dis.readUnsignedShort()));
                        break;
                    case -73:
                        instructions.add(new InvokeSpecial(index, dis.readUnsignedShort()));
                        break;
                    case -72:
                        instructions.add(new InvokeStatic(index, dis.readUnsignedShort()));
                        break;
                    case -71:
                        instructions.add(new InvokeInterface(index, dis.readUnsignedShort()));
                        dis.readByte();
                        dis.readByte();
                        break;
//                    case -70:
//                        break;
                    case -69:
                        instructions.add(new New(index, dis.readUnsignedShort()));
                        break;
                    case -68:
                        instructions.add(new NewArray(index, dis.readByte()));
                        break;
                    case -67:
                        instructions.add(new NewRefArray(index, dis.readUnsignedShort()));
                        break;
                    case -66:
                        instructions.add(new ArrayLength(index));
                        break;
                    case -65:
                        instructions.add(new Throw(index));
                        break;
                    case -64:
                        instructions.add(new Cast(index, dis.readUnsignedShort()));
                        break;
                    case -63:
                        instructions.add(new Cast(index, dis.readUnsignedShort()));
                        break;
                    case -62:
                        instructions.add(new MonitorEnter(index));
                        break;
                    case -61:
                        instructions.add(new MonitorExit(index));
                        break;
//                    case -60:
                    case -59:
                        instructions.add(new NewMultiRefArray(index, dis.readUnsignedShort(), dis.readUnsignedByte()));
                        break;
                    case -58:
                    case -57:
                        instructions.add(new BranchZero(index, opcode + 64, dis.readUnsignedShort()));
                        break;
//                    case -56:
//                    case -55:
//                        break;
                    default:
                        System.err.println("Opcode " + opcode + "unimplemented");
                }
            }
        } catch (IOException ex) {
        }
        return null;
    }
}
