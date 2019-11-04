// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package academy.yamamoto.android.general;


public interface XmlProcedure
{

    public abstract void attributeOfXml(String s, String s1);

    public abstract void endDocumentOfXml();

    public abstract boolean endTagOfXml();

    public abstract void startDocumentOfXml();

    public abstract boolean startTagOfXml(String s, int i);

    public abstract void textOfXml(String s);
}
