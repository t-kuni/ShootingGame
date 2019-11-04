// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.general;

import android.content.Context;
import android.content.res.Resources;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package academy.yamamoto.android.general:
//            XmlProcedure

public class XmlReader
{

    public XmlReader()
    {
        parser = null;
        procedure = null;
    }

    public XmlReader(Context context, int i)
    {
        parser = null;
        procedure = null;
        context = context.getResources();
        setParser(context.getXml(i));
        try
        {
            getParser().setInput(context.openRawResource(i), null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch(Context context)
        {
            return;
        }
    }

    public XmlPullParser getParser()
    {
        return parser;
    }

    public XmlProcedure getProcedure()
    {
        return procedure;
    }

    public boolean hasProcedure()
    {
        return getProcedure() != null;
    }

    public void read()
    {
        int i;
        if(!hasProcedure())
            return;
        try
        {
            i = getParser().getEventType();
        }
        catch(Exception exception)
        {
            return;
        }
        if(i != 1)
            break; /* Loop/switch isn't completed */
        getProcedure().endDocumentOfXml();
        return;
_L3:
        i = getParser().next();
        if(true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_18;
_L8:
        getProcedure().startDocumentOfXml();
          goto _L3
_L9:
        if(!getProcedure().startTagOfXml(getParser().getName(), getParser().getDepth())) goto _L3; else goto _L4
_L4:
        i = 0;
_L6:
        if(i >= getParser().getAttributeCount()) goto _L3; else goto _L5
_L5:
        getProcedure().attributeOfXml(getParser().getAttributeName(i), getParser().getAttributeValue(i));
        i++;
          goto _L6
_L11:
        getProcedure().textOfXml(getParser().getText());
          goto _L3
_L10:
        if(getProcedure().endTagOfXml()) goto _L3; else goto _L7
_L7:
        getProcedure().endDocumentOfXml();
        return;
_L1:
        i;
        JVM INSTR tableswitch 0 4: default 220
    //                   0 46
    //                   1 33
    //                   2 58
    //                   3 160
    //                   4 139;
           goto _L3 _L8 _L3 _L9 _L10 _L11
    }

    public void setParser(XmlPullParser xmlpullparser)
    {
        parser = xmlpullparser;
    }

    public void setProcedure(XmlProcedure xmlprocedure)
    {
        procedure = xmlprocedure;
    }

    private XmlPullParser parser;
    private XmlProcedure procedure;
}
