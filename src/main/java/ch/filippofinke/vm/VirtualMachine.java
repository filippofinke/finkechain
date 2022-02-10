package ch.filippofinke.vm;

import ch.filippofinke.utils.Stack;

public class VirtualMachine {
    private static final int STACK_SIZE = 1024;

    private int programCounter;
    private Stack<Byte> stack;
    private byte[] code;

    public VirtualMachine(byte[] code) {
        this.programCounter = 0;
        this.stack = new Stack<Byte>(STACK_SIZE);
        this.code = code;
    }

    public Byte run() {
        while (this.programCounter < this.code.length) {
            byte opCode = this.code[this.programCounter];
            switch (opCode) {
                case OpCode.STOP:
                    return this.stack.pop();
                case OpCode.PUSH:
                    byte value = this.code[++this.programCounter];
                    this.stack.push(value);
                    break;
                case OpCode.POP:
                    this.stack.pop();
                    break;
                case OpCode.ADD:
                case OpCode.SUB:
                case OpCode.MUL:
                case OpCode.DIV:
                case OpCode.MOD:
                case OpCode.EXP:
                case OpCode.LT:
                case OpCode.GT:
                case OpCode.EQ:
                    byte a = this.stack.pop();
                    byte b = this.stack.pop();

                    if (opCode == OpCode.ADD)
                        this.stack.push((byte) (a + b));
                    else if (opCode == OpCode.SUB)
                        this.stack.push((byte) (a - b));
                    else if (opCode == OpCode.MUL)
                        this.stack.push((byte) (a * b));
                    else if (opCode == OpCode.DIV)
                        this.stack.push((byte) (a / b));
                    else if (opCode == OpCode.MOD)
                        this.stack.push((byte) (a % b));
                    else if (opCode == OpCode.EXP)
                        this.stack.push((byte) (a ^ b));
                    else if (opCode == OpCode.LT)
                        this.stack.push((byte) (a < b ? 1 : 0));
                    else if (opCode == OpCode.GT)
                        this.stack.push((byte) (a > b ? 1 : 0));
                    else if (opCode == OpCode.EQ)
                        this.stack.push((byte) (a == b ? 1 : 0));

                    break;
                case OpCode.JUMP:
                    this.programCounter = this.code[++this.programCounter] - 1;
                    break;
                case OpCode.JUMP_IF:
                    byte condition = this.stack.pop();
                    if (condition != 0) {
                        this.programCounter = this.code[++this.programCounter] - 1;
                    } else {
                        this.programCounter++;
                    }
                    break;
                default:
                    throw new RuntimeException(String.format("Unknown opcode: 0x%02X", opCode));
            }
            this.programCounter++;
        }
        return 0;
    }

}
