//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.transformers;

import net.minecraft.launchwrapper.*;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.*;
import java.util.*;

public class ForgeTransformer implements IClassTransformer
{
    public byte[] transform(final String name, final String transformedName, final byte[] basicClass) {
        if (name.equals("net.minecraftforge.fml.common.network.handshake.NetworkDispatcher")) {
            final ClassReader classReader = new ClassReader(basicClass);
            final ClassNode classNode = new ClassNode();
            classReader.accept((ClassVisitor)classNode, 0);
            for (final Object o : classNode.methods) {
                final MethodNode methodNode = (MethodNode)o;
                if (methodNode.name.equals("handleVanilla")) {
                    final InsnList insnList = new InsnList();
                    insnList.add((AbstractInsnNode)new InsnNode(3));
                    insnList.add((AbstractInsnNode)new InsnNode(172));
                    methodNode.instructions = insnList;
                    System.out.println("[NoForge] Patched \"" + methodNode.name + "\" in " + name + ".");
                }
            }
            final ClassWriter classWriter = new ClassWriter(1);
            classNode.accept((ClassVisitor)classWriter);
            return classWriter.toByteArray();
        }
        return basicClass;
    }
}
