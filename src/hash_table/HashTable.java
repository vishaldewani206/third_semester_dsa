package hash_table;

//put, get, remove, size, hash
// linear probing ->
// quadratic probing ->

public class HashTable {
     Entry[] entries = new Entry[11];
    private int size;

    private class Entry {
        Object key, value;

        Entry(Object key, Object value){
            this.key = key;
            this.value = value;
        }

    }

    public int size(){
        return size;
    }

    private int hash(Object key){
        return (key.hashCode() & 0x7FFFFFF) % entries.length;
    }

    public Object get(Object key){
        return entries[hash(key)].value;
    }

    public Object put(Object key, Object value){
        entries[hash(key)] = new Entry(key, value);
        size++;
        return null;
    }

    public Object put2(Object key, Object value){
        int h = hash(key);
        for (int i = 0; i < entries.length; i++) {
            int j = (h + i) % entries.length;

            Entry entry = entries[j];

            if(entry == null){
                entries[j] = new Entry(key, value);
                size++;
                return  null;
            }
        }

        throw new IllegalStateException("Table is full");
    }

    public Object get2(Object key){
        int h = hash(key);
        Entry NIL = new Entry(null, null);

        for (int i = 0; i < entries.length; i++) {
            int j = (h+i) % entries.length;

            Entry entry = entries[j];

            if(entry == null){
                break;
            }

            if(entry == NIL){
                continue;
            }

            if(entry.key.equals(key)){
                return entry.value;
            }

        }

        return null;
    }

    public Object remove(Object key){
        int h = hash(key);
        Object temp = entries[h].value;

        entries[h] = null;
        --size;
        return temp;
    }

}
