package blocks

import net.minecraft.block.Block
import net.minecraft.item.{Item, ItemBlock}

object Blocks {
  val allModBlocks: Seq[Block] = Seq(TestBlocks.TestBlock())
  val allModItemBlocks: Seq[Item] = allModBlocks.map(x => new ItemBlock(x).setRegistryName(x.getRegistryName))
}
