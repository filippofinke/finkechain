package ch.filippofinke.vm;

public class OpCode {
    public static final byte STOP = 0;

    public static final byte PUSH = 1;
    public static final byte POP = 2;

    public static final byte ADD = 3;
    public static final byte SUB = 4;
    public static final byte MUL = 5;
    public static final byte DIV = 6;
    public static final byte MOD = 7;
    public static final byte EXP = 8;

    public static final byte JUMP = 9;
    public static final byte JUMP_IF = 10;

    public static final byte LT = 11;
    public static final byte GT = 12;
    public static final byte EQ = 13;
}
