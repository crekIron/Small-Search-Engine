/**
 * WordEntry
 */
public class WordEntry {

    String word;
    MyLinkedList<Position> index = new MyLinkedList<Position>();
    AVL_Tree indexAVL = new AVL_Tree();
    public WordEntry(String Word)
    {
        word=Word;
    } 
    public void addPosition(Position position)
    {
        index.add(position);
        indexAVL.root=indexAVL.insert(indexAVL.root, position);
    }
    public void addPositions(MyLinkedList<Position> positions)
    {
        index.addAll(positions);
    }
    public MyLinkedList<Position> getAllPositionsForThisWord()
    {
        return index;
    }
    // public float getTermFrequency(String word)
    // {
        
    // }
}
