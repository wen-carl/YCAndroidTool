package groovy.plugin.bytecode;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import groovy.hunter.asm.BaseWeaver;
import groovy.plugin.OkHttpHunterExtension;


public final class OkHttpWeaver extends BaseWeaver {

    private OkHttpHunterExtension okHttpHunterExtension;

    @Override
    public void setExtension(Object extension) {
        if(extension == null) return;
        this.okHttpHunterExtension = (OkHttpHunterExtension) extension;
    }

    @Override
    protected ClassVisitor wrapClassWriter(ClassWriter classWriter) {
        return new OkHttpClassAdapter(classWriter, this.okHttpHunterExtension.weaveEventListener);
    }

}
