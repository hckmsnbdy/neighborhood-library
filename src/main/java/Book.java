public class Book {

    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }
    public void  checkedOut(String name) {
        isCheckedOut = true;
        checkedOutTo = name;

    }
    public void  checkIn() {
        isCheckedOut = false;
        checkedOutTo = "";


        Book[] books =  new Book[20];

        books[0]  = new Book(1, "9780140449334", "The Republic - Plato", false, "");
        books[1]  = new Book(2, "9780140449105", "Meditations - Marcus Aurelius", false, "");
        books[2]  = new Book(3, "9780140447941", "Nicomachean Ethics - Aristotle", false, "");
        books[3]  = new Book(4, "9780140444285", "Beyond Good and Evil - Friedrich Nietzsche", false, "");
        books[4]  = new Book(5, "9780140445893", "Thus Spoke Zarathustra - Friedrich Nietzsche", false, "");
        books[5]  = new Book(6, "9780140444278", "Critique of Pure Reason - Immanuel Kant", false, "");
        books[6]  = new Book(7, "9780140442106", "Groundwork of the Metaphysics of Morals - Immanuel Kant", false, "");
        books[7]  = new Book(8, "9780140440355", "Discourse on Method - René Descartes", false, "");
        books[8]  = new Book(9, "9780140439212", "Leviathan - Thomas Hobbes", false, "");
        books[9]  = new Book(10, "9780140444957", "The Social Contract - Jean-Jacques Rousseau", false, "");
        books[10] = new Book(11, "9780140444841", "A Treatise of Human Nature - David Hume", false, "");
        books[11] = new Book(12, "9780143105824", "Being and Nothingness - Jean-Paul Sartre", false, "");
        books[12] = new Book(13, "9780141184633", "Existentialism is a Humanism - Jean-Paul Sartre", false, "");
        books[13] = new Book(14, "9780143104919", "The Myth of Sisyphus - Albert Camus", false, "");
        books[14] = new Book(15, "9780679720201", "The Stranger - Albert Camus", false, "");
        books[15] = new Book(16, "9780140447576", "Confessions - St. Augustine", false, "");
        books[16] = new Book(17, "9780140444254", "On Liberty - John Stuart Mill", false, "");
        books[17] = new Book(18, "9780140449747", "Being and Time - Martin Heidegger", false, "");
        books[18] = new Book(19, "9780199536061", "The Symposium - Plato", false, "");
        books[19] = new Book(20, "9780199535767", "Phaedo - Plato", false, "");



    }

}

