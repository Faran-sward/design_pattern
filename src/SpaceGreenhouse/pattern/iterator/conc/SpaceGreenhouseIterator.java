package SpaceGreenhouse.pattern.iterator.conc;

import SpaceGreenhouse.common.SpaceGreenhouseBlock;
import SpaceGreenhouse.pattern.iterator.Iterator;

import java.util.List;

/**
 * 太空温室类迭代器
 */
public class SpaceGreenhouseIterator implements Iterator {

    private List<SpaceGreenhouseBlock> SpaceGreenhouseBlockList;
    private int index = 0;

    public SpaceGreenhouseIterator(List<SpaceGreenhouseBlock> list) {
        this.SpaceGreenhouseBlockList = list;
    }

    @Override
    public SpaceGreenhouseBlock first() {
        return SpaceGreenhouseBlockList.get(0);
    }

    @Override
    public SpaceGreenhouseBlock next() {
        SpaceGreenhouseBlock block = null;
        if (this.hasNext()) {
            block = SpaceGreenhouseBlockList.get(index++);
        }
        return block;
    }

    @Override
    public boolean hasNext() {
        return index < SpaceGreenhouseBlockList.size();
    }

    public SpaceGreenhouseBlock getByIndex(int index_) {
        if (index_ < 0 || index_ >= SpaceGreenhouseBlockList.size()) {
            throw new IndexOutOfBoundsException("索引超出范围！");
        } else {
            this.index = index_;
            System.out.println("\n太空温室块" + (index+1) + "：");
            return SpaceGreenhouseBlockList.get(index);
        }
    }
}
