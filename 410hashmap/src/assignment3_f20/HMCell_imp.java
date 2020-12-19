package assignment3_f20;

//-------------------------------------------------------------------
// put this Interface and Implementation into your code as is
// the grader may need these methods to examine the structure
// that your code creates
//-------------------------------------------------------------------
// you may add methods and structure as you need to
// for example, you may want a toString to help with your debugging
// but to not remove what we have given here
//-------------------------------------------------------------------

public class HMCell_imp implements HMCell {
  public String key;
  public Value val;
  public HMCell next;

  HMCell_imp(String k, Value v) { key=k;  val=v; next=null; }

  @Override
  public void setKey(String newKey) { key = newKey; } 
  @Override
  public String getKey() { return key; }
  @Override
  public void setValue(Value newValue) {  val = newValue; }
  @Override
  public Value getValue() { return val; }
   @Override
  public void setNext(HMCell nextCell) { next = nextCell; }
  @Override
  public HMCell getNext() { return next; }
}