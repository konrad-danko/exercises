package practices.codewars.kyu5;
import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {

  private List<I> collection;
  private int itemsPerPage;

  /**
   * The constructor takes in an array of items and a integer indicating how many
   * items fit within a single page
   */
  public PaginationHelper(List<I> collection, int itemsPerPage) {
    this.collection = collection;
    this.itemsPerPage = itemsPerPage;
  }

  /**
   * returns the number of items within the entire collection
   */
  public int itemCount() {
    return this.collection.size();
  }

  /**
   * returns the number of pages
   */
  public int pageCount() {
    return this.itemCount()%this.itemsPerPage==0 ?
        this.itemCount()/this.itemsPerPage :
        this.itemCount()/this.itemsPerPage+1;
  }

  /**
   * returns the number of items on the current page. page_index is zero based.
   * this method should return -1 for pageIndex values that are out of range
   */
  public int pageItemCount(int pageIndex) {
    System.out.println(itemsPerPage + " " + collection);
    System.out.println(pageIndex);
    if(pageIndex<0 || pageIndex>this.pageCount()-1) return -1;
    if(this.itemCount()%this.itemsPerPage==0) return this.itemsPerPage;
    if(pageIndex==this.pageCount()-1) return this.itemCount()%this.itemsPerPage;
    return this.itemsPerPage;
  }

  /**
   * determines what page an item is on. Zero based indexes
   * this method should return -1 for itemIndex values that are out of range
   */
  public int pageIndex(int itemIndex) {
    if(itemIndex<0 || itemIndex+1>this.itemCount()) return -1;
    return itemIndex/this.itemsPerPage;
  }
}