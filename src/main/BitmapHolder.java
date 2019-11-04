// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package main;

import academy.yamamoto.android.general.Gen;
import android.content.Context;
import android.graphics.Bitmap;

// Referenced classes of package main:
//            Effect

public class BitmapHolder
{

    public BitmapHolder()
    {
    }

    public static void destroy(int i)
    {
        get(i).recycle();
        set(i, null);
    }

    public static void destroyAll()
    {
        int i = 0;
        do
        {
            if(i >= 150)
            {
                Effect.destroyAll();
                return;
            }
            if(has(i))
                destroy(i);
            i++;
        } while(true);
    }

    public static Bitmap get(int i)
    {
        return getBitmaps()[i];
    }

    private static Bitmap[] getBitmaps()
    {
        return bitmaps;
    }

    public static boolean has(int i)
    {
        return get(i) != null;
    }

    public static Bitmap load(Context context, int i)
    {
        if(has(i)) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 0 146: default 612
    //                   0 617
    //                   1 631
    //                   2 645
    //                   3 659
    //                   4 673
    //                   5 687
    //                   6 701
    //                   7 716
    //                   8 731
    //                   9 746
    //                   10 761
    //                   11 776
    //                   12 791
    //                   13 806
    //                   14 821
    //                   15 836
    //                   16 851
    //                   17 866
    //                   18 881
    //                   19 896
    //                   20 911
    //                   21 926
    //                   22 941
    //                   23 956
    //                   24 971
    //                   25 986
    //                   26 1001
    //                   27 1016
    //                   28 1031
    //                   29 1046
    //                   30 1061
    //                   31 1076
    //                   32 1091
    //                   33 1106
    //                   34 1121
    //                   35 1136
    //                   36 1151
    //                   37 1166
    //                   38 1181
    //                   39 1196
    //                   40 1211
    //                   41 1226
    //                   42 1241
    //                   43 1256
    //                   44 1271
    //                   45 1286
    //                   46 1301
    //                   47 1316
    //                   48 1331
    //                   49 1346
    //                   50 1361
    //                   51 1376
    //                   52 1391
    //                   53 1406
    //                   54 1421
    //                   55 1436
    //                   56 1451
    //                   57 1466
    //                   58 1481
    //                   59 1496
    //                   60 1511
    //                   61 1526
    //                   62 1541
    //                   63 1556
    //                   64 1571
    //                   65 1586
    //                   66 1601
    //                   67 1616
    //                   68 1631
    //                   69 1646
    //                   70 1661
    //                   71 1676
    //                   72 1691
    //                   73 1706
    //                   74 1721
    //                   75 1736
    //                   76 1751
    //                   77 1766
    //                   78 1781
    //                   79 1796
    //                   80 1811
    //                   81 1826
    //                   82 1841
    //                   83 1856
    //                   84 1871
    //                   85 1886
    //                   86 1901
    //                   87 1916
    //                   88 1931
    //                   89 1946
    //                   90 1961
    //                   91 1976
    //                   92 1991
    //                   93 2006
    //                   94 2021
    //                   95 2036
    //                   96 2051
    //                   97 2066
    //                   98 2081
    //                   99 2096
    //                   100 2111
    //                   101 2126
    //                   102 2141
    //                   103 2156
    //                   104 2207
    //                   105 2226
    //                   106 2246
    //                   107 2264
    //                   108 2283
    //                   109 2302
    //                   110 2322
    //                   111 2341
    //                   112 2361
    //                   113 2380
    //                   114 2400
    //                   115 2419
    //                   116 2439
    //                   117 2457
    //                   118 2597
    //                   119 2616
    //                   120 2636
    //                   121 2655
    //                   122 2674
    //                   123 2694
    //                   124 2476
    //                   125 2495
    //                   126 2515
    //                   127 2534
    //                   128 2714
    //                   129 2734
    //                   130 2754
    //                   131 2774
    //                   132 2994
    //                   133 2171
    //                   134 2554
    //                   135 2575
    //                   136 2794
    //                   137 2814
    //                   138 2834
    //                   139 2854
    //                   140 2874
    //                   141 2894
    //                   142 2914
    //                   143 2934
    //                   144 2954
    //                   145 2974
    //                   146 2191;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68 _L69 _L70 _L71 _L72 _L73 _L74 _L75 _L76 _L77 _L78 _L79 _L80 _L81 _L82 _L83 _L84 _L85 _L86 _L87 _L88 _L89 _L90 _L91 _L92 _L93 _L94 _L95 _L96 _L97 _L98 _L99 _L100 _L101 _L102 _L103 _L104 _L105 _L106 _L107 _L108 _L109 _L110 _L111 _L112 _L113 _L114 _L115 _L116 _L117 _L118 _L119 _L120 _L121 _L122 _L123 _L124 _L125 _L126 _L127 _L128 _L129 _L130 _L131 _L132 _L133 _L134 _L135 _L136 _L137 _L138 _L139 _L140 _L141 _L142 _L143 _L144 _L145 _L146 _L147 _L148 _L149
_L2:
        return get(i);
_L3:
        set(0, Gen.makeImage(context, 0x7f020000));
        continue; /* Loop/switch isn't completed */
_L4:
        set(1, Gen.makeImage(context, 0x7f020001));
        continue; /* Loop/switch isn't completed */
_L5:
        set(2, Gen.makeImage(context, 0x7f020002));
        continue; /* Loop/switch isn't completed */
_L6:
        set(3, Gen.makeImage(context, 0x7f020003));
        continue; /* Loop/switch isn't completed */
_L7:
        set(4, Gen.makeImage(context, 0x7f020004));
        continue; /* Loop/switch isn't completed */
_L8:
        set(5, Gen.makeImage(context, 0x7f020005));
        continue; /* Loop/switch isn't completed */
_L9:
        set(6, Gen.makeImage(context, 0x7f020006));
        continue; /* Loop/switch isn't completed */
_L10:
        set(7, Gen.makeImage(context, 0x7f020007));
        continue; /* Loop/switch isn't completed */
_L11:
        set(8, Gen.makeImage(context, 0x7f020008));
        continue; /* Loop/switch isn't completed */
_L12:
        set(9, Gen.makeImage(context, 0x7f020009));
        continue; /* Loop/switch isn't completed */
_L13:
        set(10, Gen.makeImage(context, 0x7f02000a));
        continue; /* Loop/switch isn't completed */
_L14:
        set(11, Gen.makeImage(context, 0x7f02000b));
        continue; /* Loop/switch isn't completed */
_L15:
        set(12, Gen.makeImage(context, 0x7f02000c));
        continue; /* Loop/switch isn't completed */
_L16:
        set(13, Gen.makeImage(context, 0x7f02000f));
        continue; /* Loop/switch isn't completed */
_L17:
        set(14, Gen.makeImage(context, 0x7f02000d));
        continue; /* Loop/switch isn't completed */
_L18:
        set(15, Gen.makeImage(context, 0x7f02000e));
        continue; /* Loop/switch isn't completed */
_L19:
        set(16, Gen.makeImage(context, 0x7f020010));
        continue; /* Loop/switch isn't completed */
_L20:
        set(17, Gen.makeImage(context, 0x7f020011));
        continue; /* Loop/switch isn't completed */
_L21:
        set(18, Gen.makeImage(context, 0x7f020012));
        continue; /* Loop/switch isn't completed */
_L22:
        set(19, Gen.makeImage(context, 0x7f020013));
        continue; /* Loop/switch isn't completed */
_L23:
        set(20, Gen.makeImage(context, 0x7f020014));
        continue; /* Loop/switch isn't completed */
_L24:
        set(21, Gen.makeImage(context, 0x7f020016));
        continue; /* Loop/switch isn't completed */
_L25:
        set(22, Gen.makeImage(context, 0x7f020015));
        continue; /* Loop/switch isn't completed */
_L26:
        set(23, Gen.makeImage(context, 0x7f020018));
        continue; /* Loop/switch isn't completed */
_L27:
        set(24, Gen.makeImage(context, 0x7f020017));
        continue; /* Loop/switch isn't completed */
_L28:
        set(25, Gen.makeImage(context, 0x7f02001a));
        continue; /* Loop/switch isn't completed */
_L29:
        set(26, Gen.makeImage(context, 0x7f020019));
        continue; /* Loop/switch isn't completed */
_L30:
        set(27, Gen.makeImage(context, 0x7f02001b));
        continue; /* Loop/switch isn't completed */
_L31:
        set(28, Gen.makeImage(context, 0x7f02001c));
        continue; /* Loop/switch isn't completed */
_L32:
        set(29, Gen.makeImage(context, 0x7f02001d));
        continue; /* Loop/switch isn't completed */
_L33:
        set(30, Gen.makeImage(context, 0x7f02001e));
        continue; /* Loop/switch isn't completed */
_L34:
        set(31, Gen.makeImage(context, 0x7f02001f));
        continue; /* Loop/switch isn't completed */
_L35:
        set(32, Gen.makeImage(context, 0x7f020020));
        continue; /* Loop/switch isn't completed */
_L36:
        set(33, Gen.makeImage(context, 0x7f020021));
        continue; /* Loop/switch isn't completed */
_L37:
        set(34, Gen.makeImage(context, 0x7f020022));
        continue; /* Loop/switch isn't completed */
_L38:
        set(35, Gen.makeImage(context, 0x7f020023));
        continue; /* Loop/switch isn't completed */
_L39:
        set(36, Gen.makeImage(context, 0x7f020024));
        continue; /* Loop/switch isn't completed */
_L40:
        set(37, Gen.makeImage(context, 0x7f020025));
        continue; /* Loop/switch isn't completed */
_L41:
        set(38, Gen.makeImage(context, 0x7f020026));
        continue; /* Loop/switch isn't completed */
_L42:
        set(39, Gen.makeImage(context, 0x7f020027));
        continue; /* Loop/switch isn't completed */
_L43:
        set(40, Gen.makeImage(context, 0x7f020028));
        continue; /* Loop/switch isn't completed */
_L44:
        set(41, Gen.makeImage(context, 0x7f02002a));
        continue; /* Loop/switch isn't completed */
_L45:
        set(42, Gen.makeImage(context, 0x7f020029));
        continue; /* Loop/switch isn't completed */
_L46:
        set(43, Gen.makeImage(context, 0x7f02002b));
        continue; /* Loop/switch isn't completed */
_L47:
        set(44, Gen.makeImage(context, 0x7f02002c));
        continue; /* Loop/switch isn't completed */
_L48:
        set(45, Gen.makeImage(context, 0x7f02002d));
        continue; /* Loop/switch isn't completed */
_L49:
        set(46, Gen.makeImage(context, 0x7f02002e));
        continue; /* Loop/switch isn't completed */
_L50:
        set(47, Gen.makeImage(context, 0x7f02002f));
        continue; /* Loop/switch isn't completed */
_L51:
        set(48, Gen.makeImage(context, 0x7f020030));
        continue; /* Loop/switch isn't completed */
_L52:
        set(49, Gen.makeImage(context, 0x7f020031));
        continue; /* Loop/switch isn't completed */
_L53:
        set(50, Gen.makeImage(context, 0x7f020032));
        continue; /* Loop/switch isn't completed */
_L54:
        set(51, Gen.makeImage(context, 0x7f020033));
        continue; /* Loop/switch isn't completed */
_L55:
        set(52, Gen.makeImage(context, 0x7f020034));
        continue; /* Loop/switch isn't completed */
_L56:
        set(53, Gen.makeImage(context, 0x7f020035));
        continue; /* Loop/switch isn't completed */
_L57:
        set(54, Gen.makeImage(context, 0x7f020036));
        continue; /* Loop/switch isn't completed */
_L58:
        set(55, Gen.makeImage(context, 0x7f020037));
        continue; /* Loop/switch isn't completed */
_L59:
        set(56, Gen.makeImage(context, 0x7f020039));
        continue; /* Loop/switch isn't completed */
_L60:
        set(57, Gen.makeImage(context, 0x7f020038));
        continue; /* Loop/switch isn't completed */
_L61:
        set(58, Gen.makeImage(context, 0x7f02003a));
        continue; /* Loop/switch isn't completed */
_L62:
        set(59, Gen.makeImage(context, 0x7f02003b));
        continue; /* Loop/switch isn't completed */
_L63:
        set(60, Gen.makeImage(context, 0x7f02003c));
        continue; /* Loop/switch isn't completed */
_L64:
        set(61, Gen.makeImage(context, 0x7f02003d));
        continue; /* Loop/switch isn't completed */
_L65:
        set(62, Gen.makeImage(context, 0x7f02003e));
        continue; /* Loop/switch isn't completed */
_L66:
        set(63, Gen.makeImage(context, 0x7f02003f));
        continue; /* Loop/switch isn't completed */
_L67:
        set(64, Gen.makeImage(context, 0x7f020040));
        continue; /* Loop/switch isn't completed */
_L68:
        set(65, Gen.makeImage(context, 0x7f020041));
        continue; /* Loop/switch isn't completed */
_L69:
        set(66, Gen.makeImage(context, 0x7f020042));
        continue; /* Loop/switch isn't completed */
_L70:
        set(67, Gen.makeImage(context, 0x7f020043));
        continue; /* Loop/switch isn't completed */
_L71:
        set(68, Gen.makeImage(context, 0x7f020044));
        continue; /* Loop/switch isn't completed */
_L72:
        set(69, Gen.makeImage(context, 0x7f020045));
        continue; /* Loop/switch isn't completed */
_L73:
        set(70, Gen.makeImage(context, 0x7f020047));
        continue; /* Loop/switch isn't completed */
_L74:
        set(71, Gen.makeImage(context, 0x7f020048));
        continue; /* Loop/switch isn't completed */
_L75:
        set(72, Gen.makeImage(context, 0x7f020049));
        continue; /* Loop/switch isn't completed */
_L76:
        set(73, Gen.makeImage(context, 0x7f020046));
        continue; /* Loop/switch isn't completed */
_L77:
        set(74, Gen.makeImage(context, 0x7f02004a));
        continue; /* Loop/switch isn't completed */
_L78:
        set(75, Gen.makeImage(context, 0x7f02004b));
        continue; /* Loop/switch isn't completed */
_L79:
        set(76, Gen.makeImage(context, 0x7f02004c));
        continue; /* Loop/switch isn't completed */
_L80:
        set(77, Gen.makeImage(context, 0x7f02004f));
        continue; /* Loop/switch isn't completed */
_L81:
        set(78, Gen.makeImage(context, 0x7f020050));
        continue; /* Loop/switch isn't completed */
_L82:
        set(79, Gen.makeImage(context, 0x7f020051));
        continue; /* Loop/switch isn't completed */
_L83:
        set(80, Gen.makeImage(context, 0x7f020052));
        continue; /* Loop/switch isn't completed */
_L84:
        set(81, Gen.makeImage(context, 0x7f020053));
        continue; /* Loop/switch isn't completed */
_L85:
        set(82, Gen.makeImage(context, 0x7f020054));
        continue; /* Loop/switch isn't completed */
_L86:
        set(83, Gen.makeImage(context, 0x7f020055));
        continue; /* Loop/switch isn't completed */
_L87:
        set(84, Gen.makeImage(context, 0x7f020056));
        continue; /* Loop/switch isn't completed */
_L88:
        set(85, Gen.makeImage(context, 0x7f020057));
        continue; /* Loop/switch isn't completed */
_L89:
        set(86, Gen.makeImage(context, 0x7f020058));
        continue; /* Loop/switch isn't completed */
_L90:
        set(87, Gen.makeImage(context, 0x7f020059));
        continue; /* Loop/switch isn't completed */
_L91:
        set(88, Gen.makeImage(context, 0x7f02005a));
        continue; /* Loop/switch isn't completed */
_L92:
        set(89, Gen.makeImage(context, 0x7f02005b));
        continue; /* Loop/switch isn't completed */
_L93:
        set(90, Gen.makeImage(context, 0x7f02005c));
        continue; /* Loop/switch isn't completed */
_L94:
        set(91, Gen.makeImage(context, 0x7f02005d));
        continue; /* Loop/switch isn't completed */
_L95:
        set(92, Gen.makeImage(context, 0x7f02005e));
        continue; /* Loop/switch isn't completed */
_L96:
        set(93, Gen.makeImage(context, 0x7f02005f));
        continue; /* Loop/switch isn't completed */
_L97:
        set(94, Gen.makeImage(context, 0x7f020060));
        continue; /* Loop/switch isn't completed */
_L98:
        set(95, Gen.makeImage(context, 0x7f020061));
        continue; /* Loop/switch isn't completed */
_L99:
        set(96, Gen.makeImage(context, 0x7f020062));
        continue; /* Loop/switch isn't completed */
_L100:
        set(97, Gen.makeImage(context, 0x7f020063));
        continue; /* Loop/switch isn't completed */
_L101:
        set(98, Gen.makeImage(context, 0x7f020064));
        continue; /* Loop/switch isn't completed */
_L102:
        set(99, Gen.makeImage(context, 0x7f020065));
        continue; /* Loop/switch isn't completed */
_L103:
        set(100, Gen.makeImage(context, 0x7f020066));
        continue; /* Loop/switch isn't completed */
_L104:
        set(101, Gen.makeImage(context, 0x7f020067));
        continue; /* Loop/switch isn't completed */
_L105:
        set(102, Gen.makeImage(context, 0x7f020068));
        continue; /* Loop/switch isn't completed */
_L106:
        set(103, Gen.makeImage(context, 0x7f020069));
        continue; /* Loop/switch isn't completed */
_L136:
        set(133, Effect.clipBitmap(load(context, 68), 4, 1));
        continue; /* Loop/switch isn't completed */
_L149:
        set(146, Gen.makeImage(context, 0x7f02004e));
        continue; /* Loop/switch isn't completed */
_L107:
        set(104, Gen.changeBrightness(load(context, 84), 100));
        continue; /* Loop/switch isn't completed */
_L108:
        set(105, Gen.changeBrightness(load(context, 84), 200));
        continue; /* Loop/switch isn't completed */
_L109:
        set(106, Gen.changeBrightness(load(context, 1), 100));
        continue; /* Loop/switch isn't completed */
_L110:
        set(107, Gen.changeBrightness(load(context, 1), 200));
        continue; /* Loop/switch isn't completed */
_L111:
        set(108, Gen.changeBrightness(load(context, 54), 100));
        continue; /* Loop/switch isn't completed */
_L112:
        set(109, Gen.changeBrightness(load(context, 54), 200));
        continue; /* Loop/switch isn't completed */
_L113:
        set(110, Gen.changeBrightness(load(context, 12), 100));
        continue; /* Loop/switch isn't completed */
_L114:
        set(111, Gen.changeBrightness(load(context, 12), 200));
        continue; /* Loop/switch isn't completed */
_L115:
        set(112, Gen.changeBrightness(load(context, 55), 100));
        continue; /* Loop/switch isn't completed */
_L116:
        set(113, Gen.changeBrightness(load(context, 55), 200));
        continue; /* Loop/switch isn't completed */
_L117:
        set(114, Gen.changeBrightness(load(context, 96), 100));
        continue; /* Loop/switch isn't completed */
_L118:
        set(115, Gen.changeBrightness(load(context, 96), 200));
        continue; /* Loop/switch isn't completed */
_L119:
        set(116, Gen.changeBrightness(load(context, 0), 100));
        continue; /* Loop/switch isn't completed */
_L120:
        set(117, Gen.changeBrightness(load(context, 0), 200));
        continue; /* Loop/switch isn't completed */
_L127:
        set(124, Gen.changeBrightness(load(context, 56), 100));
        continue; /* Loop/switch isn't completed */
_L128:
        set(125, Gen.changeBrightness(load(context, 56), 200));
        continue; /* Loop/switch isn't completed */
_L129:
        set(126, Gen.changeBrightness(load(context, 57), 100));
        continue; /* Loop/switch isn't completed */
_L130:
        set(127, Gen.changeBrightness(load(context, 57), 200));
        continue; /* Loop/switch isn't completed */
_L137:
        set(134, Gen.changeBrightness(load(context, 133), 100));
        continue; /* Loop/switch isn't completed */
_L138:
        set(135, Gen.changeBrightness(load(context, 133), 200));
        continue; /* Loop/switch isn't completed */
_L121:
        set(118, Gen.filteringToRed(load(context, 15), 100));
        continue; /* Loop/switch isn't completed */
_L122:
        set(119, Gen.filteringToRed(load(context, 15), 200));
        continue; /* Loop/switch isn't completed */
_L123:
        set(120, Gen.changeBrightness(load(context, 93), 50));
        continue; /* Loop/switch isn't completed */
_L124:
        set(121, Gen.changeBrightness(load(context, 93), 100));
        continue; /* Loop/switch isn't completed */
_L125:
        set(122, Gen.changeBrightness(load(context, 93), 150));
        continue; /* Loop/switch isn't completed */
_L126:
        set(123, Gen.changeBrightness(load(context, 93), 200));
        continue; /* Loop/switch isn't completed */
_L131:
        set(128, Effect.clipBitmap(load(context, 58), 3, 0));
        continue; /* Loop/switch isn't completed */
_L132:
        set(129, Effect.clipBitmap(load(context, 58), 4, 0));
        continue; /* Loop/switch isn't completed */
_L133:
        set(130, Effect.clipBitmap(load(context, 58), 0, 1));
        continue; /* Loop/switch isn't completed */
_L134:
        set(131, Effect.clipBitmap(load(context, 58), 2, 1));
        continue; /* Loop/switch isn't completed */
_L139:
        set(136, Effect.clipBitmap(load(context, 62), 0, 1));
        continue; /* Loop/switch isn't completed */
_L140:
        set(137, Effect.clipBitmap(load(context, 62), 1, 1));
        continue; /* Loop/switch isn't completed */
_L141:
        set(138, Effect.clipBitmap(load(context, 62), 2, 1));
        continue; /* Loop/switch isn't completed */
_L142:
        set(139, Effect.clipBitmap(load(context, 62), 3, 1));
        continue; /* Loop/switch isn't completed */
_L143:
        set(140, Effect.clipBitmap(load(context, 62), 3, 2));
        continue; /* Loop/switch isn't completed */
_L144:
        set(141, Effect.clipBitmap(load(context, 62), 3, 4));
        continue; /* Loop/switch isn't completed */
_L145:
        set(142, Effect.clipBitmap(load(context, 62), 4, 1));
        continue; /* Loop/switch isn't completed */
_L146:
        set(143, Effect.clipBitmap(load(context, 62), 0, 2));
        continue; /* Loop/switch isn't completed */
_L147:
        set(144, Effect.clipBitmap(load(context, 62), 1, 2));
        continue; /* Loop/switch isn't completed */
_L148:
        set(145, Effect.clipBitmap(load(context, 62), 2, 2));
        continue; /* Loop/switch isn't completed */
_L135:
        set(132, Bitmap.createBitmap(1400, 800, android.graphics.Bitmap.Config.ARGB_8888));
        if(true) goto _L2; else goto _L150
_L150:
    }

    private static void set(int i, Bitmap bitmap)
    {
        getBitmaps()[i] = bitmap;
    }

    public static final int ALLOWS00 = 128;
    public static final int ALLOWS01 = 129;
    public static final int ALLOWS02 = 130;
    public static final int ALLOWS03 = 131;
    public static final int ALRAUNE = 0;
    public static final int ALRAUNE_BRIGHT00 = 116;
    public static final int ALRAUNE_BRIGHT01 = 117;
    public static final int ASTERISK = 1;
    public static final int ASTERISK_BRIGHT00 = 106;
    public static final int ASTERISK_BRIGHT01 = 107;
    public static final int ATTENTION = 2;
    public static final int BATTLE_BACK = 132;
    public static final int BITMAP_COUNT = 150;
    public static final int BLACK_BAND = 3;
    public static final int BLACK_FILTER00 = 4;
    public static final int BLACK_FILTER01 = 5;
    public static final int BLACK_FILTER02 = 6;
    public static final int BLACK_FILTER03 = 7;
    public static final int BLACK_FILTER04 = 8;
    public static final int BLUE_FILTER00 = 9;
    public static final int BLUE_FILTER01 = 10;
    public static final int BLUE_FILTER02 = 11;
    public static final int BOMB = 12;
    public static final int BOMB_BRIGHT00 = 110;
    public static final int BOMB_BRIGHT01 = 111;
    public static final int BOOK = 14;
    public static final int BOOK2 = 15;
    public static final int BOOK2_RED_FILTER00 = 118;
    public static final int BOOK2_RED_FILTER01 = 119;
    public static final int BOOK_BIG = 13;
    public static final int BOSS_RUSH00 = 16;
    public static final int BOSS_RUSH01 = 17;
    public static final int BOSS_RUSH02 = 18;
    public static final int BOSS_RUSH03 = 19;
    public static final int BOSS_RUSH04 = 20;
    public static final int CHAR_A = 22;
    public static final int CHAR_A_BIG = 21;
    public static final int CHAR_D = 24;
    public static final int CHAR_D_BIG = 23;
    public static final int CHAR_E = 26;
    public static final int CHAR_EIGHT = 27;
    public static final int CHAR_E_BIG = 25;
    public static final int CHAR_FIVE = 29;
    public static final int CHAR_FOUR = 30;
    public static final int CHAR_F_BIG = 28;
    public static final int CHAR_G_BIG = 31;
    public static final int CHAR_H_BIG = 32;
    public static final int CHAR_I_BIG = 33;
    public static final int CHAR_L = 34;
    public static final int CHAR_M = 35;
    public static final int CHAR_MINUS = 36;
    public static final int CHAR_N = 37;
    public static final int CHAR_NINE = 38;
    public static final int CHAR_O = 39;
    public static final int CHAR_ONE = 40;
    public static final int CHAR_R = 42;
    public static final int CHAR_R_BIG = 41;
    public static final int CHAR_S = 43;
    public static final int CHAR_SEVEN = 44;
    public static final int CHAR_SIX = 45;
    public static final int CHAR_THREE = 47;
    public static final int CHAR_TWO = 48;
    public static final int CHAR_T_BIG = 46;
    public static final int CHAR_Y_BIG = 49;
    public static final int CHAR_ZERO = 50;
    public static final int CLOUD00 = 51;
    public static final int CLOUD01 = 52;
    public static final int CLOUD02 = 53;
    public static final int CRESCENT = 54;
    public static final int CRESCENT_BRIGHT00 = 108;
    public static final int CRESCENT_BRIGHT01 = 109;
    public static final int CUBE = 55;
    public static final int CUBE_BRIGHT00 = 112;
    public static final int CUBE_BRIGHT01 = 113;
    public static final int DULLAHAN = 57;
    public static final int DULLAHAN_BRIGHT00 = 126;
    public static final int DULLAHAN_BRIGHT01 = 127;
    public static final int DULLAHAN_R = 56;
    public static final int DULLAHAN_R_BRIGHT00 = 124;
    public static final int DULLAHAN_R_BRIGHT01 = 125;
    public static final int EFFECT_ALLOWS = 58;
    public static final int EFFECT_AURA = 59;
    public static final int EFFECT_BOMB00 = 60;
    public static final int EFFECT_BOMB01 = 61;
    public static final int EFFECT_FIRE = 62;
    public static final int EFFECT_FIRERING = 63;
    public static final int EFFECT_PLASMA = 64;
    public static final int EFFECT_POINT = 65;
    public static final int EFFECT_PRASMA01 = 66;
    public static final int EFFECT_PRISM = 67;
    public static final int EFFECT_SWORD = 68;
    public static final int EFFECT_WIND = 69;
    public static final int EL_FIRE = 73;
    public static final int EL_FIRE_B = 70;
    public static final int EL_FIRE_M = 71;
    public static final int EL_FIRE_N = 72;
    public static final int EL_PLASMA = 74;
    public static final int FIRE00 = 136;
    public static final int FIRE01 = 137;
    public static final int FIRE02 = 138;
    public static final int FIRE03 = 139;
    public static final int FIRE04 = 140;
    public static final int FIRE05 = 141;
    public static final int FIRE06 = 142;
    public static final int FIRE07 = 143;
    public static final int FIRE08 = 144;
    public static final int FIRE09 = 145;
    public static final int GRASS = 75;
    public static final int HIT = 76;
    public static final int INPUT_TOUCH = 146;
    public static final int LIFE_BAR = 77;
    public static final int LIFE_GAUGE = 78;
    public static final int MACHINE_BALL = 79;
    public static final int PRISM00 = 80;
    public static final int PRISM01 = 81;
    public static final int RAY = 82;
    public static final int RESULT_BACK = 83;
    public static final int SAN = 84;
    public static final int SAN_BRIGHT00 = 104;
    public static final int SAN_BRIGHT01 = 105;
    public static final int SCORE_BOARD = 85;
    public static final int SHELL = 86;
    public static final int STONE = 87;
    public static final int STR_COMBO_BONUS = 88;
    public static final int STR_RESULT = 89;
    public static final int SWORD = 133;
    public static final int SWORD_BRIGHT00 = 134;
    public static final int SWORD_BRIGHT01 = 135;
    public static final int TITLE_BACK = 90;
    public static final int TITLE_BOARD = 91;
    public static final int TITLE_ENDRESS = 92;
    public static final int TITLE_LOGO = 93;
    public static final int TITLE_LOGO_BRIGHT00 = 120;
    public static final int TITLE_LOGO_BRIGHT01 = 121;
    public static final int TITLE_LOGO_BRIGHT02 = 122;
    public static final int TITLE_LOGO_BRIGHT03 = 123;
    public static final int TITLE_NORMAL = 94;
    public static final int WEAPON_BOARD = 95;
    public static final int WHEEL = 96;
    public static final int WHEEL_BRIGHT00 = 114;
    public static final int WHEEL_BRIGHT01 = 115;
    public static final int WHITE_FILTER00 = 97;
    public static final int WHITE_FILTER01 = 98;
    public static final int WHITE_FILTER02 = 99;
    public static final int WISP = 100;
    public static final int WISP0 = 101;
    public static final int WISP1 = 102;
    public static final int WISP2 = 103;
    private static Bitmap bitmaps[] = new Bitmap[150];

}
