package items

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import util.OverGamesMod

object TestItems {

  case class TestItem() extends Item {
    setCreativeTab(CreativeTabs.MISC)
    setRegistryName("Test_Item")
    setUnlocalizedName(OverGamesMod.modId + "." + getRegistryName)
  }
}
