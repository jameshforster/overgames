package blocks

import net.minecraft.block.{Block, SoundType}
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import util.OverGamesMod

object TestBlocks {

  case class TestBlock() extends Block(Material.ROCK) {
    setCreativeTab(CreativeTabs.MISC)
    setSoundType(SoundType.STONE)
    setRegistryName("Test_Block")
    setUnlocalizedName(OverGamesMod.modId + "." + getRegistryName)
  }
}
