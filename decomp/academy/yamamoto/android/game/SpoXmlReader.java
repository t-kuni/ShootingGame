// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.game;

import academy.yamamoto.android.general.XmlProcedure;
import academy.yamamoto.android.general.XmlReader;
import android.content.Context;
import java.util.Iterator;
import java.util.Vector;

public class SpoXmlReader
    implements XmlProcedure
{

    public SpoXmlReader(Context context, int i, String s)
    {
        reader = null;
        id = "";
        integrity = true;
        enable = false;
        currentTag = "";
        objectNames = null;
        reader = new XmlReader(context, i);
        id = s;
        objectNames = new Vector(4);
        reader.setProcedure(this);
        reader.read();
    }

    public void attributeOfXml(String s, String s1)
    {
        if(!currentTag.equals("objects")) goto _L2; else goto _L1
_L1:
        if(!s.equals("id")) goto _L4; else goto _L3
_L3:
        if(!s1.equals(id)) goto _L6; else goto _L5
_L5:
        enable = true;
_L8:
        return;
_L6:
        enable = false;
        return;
_L4:
        integrity = false;
        return;
_L2:
        if(currentTag.equals("object"))
            if(s.equals("name"))
            {
                objectNames.add(s1);
                return;
            } else
            {
                integrity = false;
                return;
            }
        if(true) goto _L8; else goto _L7
_L7:
    }

    public void endDocumentOfXml()
    {
    }

    public boolean endTagOfXml()
    {
        return integrity;
    }

    public Iterator getResult()
    {
        if(!integrity)
            objectNames.clear();
        return objectNames.iterator();
    }

    public boolean integrityCheck()
    {
        return integrity;
    }

    public void startDocumentOfXml()
    {
    }

    public boolean startTagOfXml(String s, int i)
    {
        if(integrity) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        currentTag = s;
        if(!s.equals("placement"))
            break; /* Loop/switch isn't completed */
        if(i != 1)
        {
            integrity = false;
            return false;
        }
        if(true) goto _L1; else goto _L3
_L3:
        if(s.equals("objects"))
            if(i != 2)
            {
                integrity = false;
                return false;
            } else
            {
                return true;
            }
        if(s.equals("object"))
        {
            if(i != 3)
            {
                integrity = false;
                return false;
            }
            if(enable)
                return true;
        }
        if(true) goto _L1; else goto _L4
_L4:
    }

    public void textOfXml(String s)
    {
    }

    private String currentTag;
    private boolean enable;
    private String id;
    private boolean integrity;
    private Vector objectNames;
    private XmlReader reader;
}
