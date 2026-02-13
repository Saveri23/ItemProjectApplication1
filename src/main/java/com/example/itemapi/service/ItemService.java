@Service
public class ItemService {

    private List<Item> items = new ArrayList<>();

    public List<Item> getAllItems() {
        return items;
    }

    public Optional<Item> getItemById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }

    public Item addItem(Item item) {
        items.add(item);
        return item;
    }

    public Item updateItem(int id, Item updatedItem) {
        for (Item i : items) {
            if (i.getId() == id) {
                i.setName(updatedItem.getName());
                i.setPrice(updatedItem.getPrice());
                return i;
            }
        }
        return null;
    }

    public boolean deleteItem(int id) {
        return items.removeIf(i -> i.getId() == id);
    }
}
