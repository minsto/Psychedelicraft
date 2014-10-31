/*
 *  Copyright (c) 2014, Lukas Tenbrink.
 *  * http://lukas.axxim.net
 */

package ivorius.psychedelicraft.fluids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

/**
 * Created by lukas on 29.10.14.
 */
public class FluidSimple extends Fluid implements FluidWithIconSymbolRegistering, TranslucentFluid
{
    protected String symbolIconName;
    @SideOnly(Side.CLIENT)
    protected IIcon symbolIcon;

    protected String flowingIconName;
    protected String stillIconName;

    protected int color;

    public FluidSimple(String fluidName)
    {
        super(fluidName);
    }

    public String getSymbolIconName()
    {
        return symbolIconName;
    }

    public void setSymbolIconName(String symbolIconName)
    {
        this.symbolIconName = symbolIconName;
    }

    public String getFlowingIconName()
    {
        return flowingIconName;
    }

    public void setFlowingIconName(String flowingIconName)
    {
        this.flowingIconName = flowingIconName;
    }

    public String getStillIconName()
    {
        return stillIconName;
    }

    public void setStillIconName(String stillIconName)
    {
        this.stillIconName = stillIconName;
    }

    @Override
    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    @Override
    public IIcon getIconSymbol(FluidStack fluidStack, int textureType)
    {
        return textureType == TEXTURE_TYPE_ITEM ? symbolIcon : null;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister, int textureType)
    {
        if (textureType == TEXTURE_TYPE_ITEM && symbolIconName != null)
            symbolIcon = iconRegister.registerIcon(symbolIconName);

        if (textureType == TEXTURE_TYPE_BLOCK)
        {
            if (flowingIconName != null)
                flowingIcon = iconRegister.registerIcon(flowingIconName);
            if (stillIconName != null)
                stillIcon = iconRegister.registerIcon(stillIconName);
        }
    }

    public void addCreativeSubtypes(List<FluidStack> list)
    {
        list.add(new FluidStack(this, 1));
    }
}