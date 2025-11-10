# Library Borrowing Record Manager

# Sample data (book_name: borrow_count)
books = {
    "Python Basics": 12,
    "Data Science": 8,
    "Machine Learning": 20,
    "Algorithms": 5,
    "C Programming": 0,
    "Database Systems": 8
}

# Sample data (member_name: number_of_books_borrowed)
members = {
    "Alice": 3,
    "Bob": 0,
    "Charlie": 2,
    "David": 0,
    "Eve": 5
}

# 1️⃣ Compute average number of books borrowed by all members
def average_books_borrowed(members):
    total = sum(members.values())
    avg = total / len(members)
    return avg

# 2️⃣ Find the book with the highest and lowest borrow count
def highest_and_lowest_borrowed(books):
    highest = max(books, key=books.get)
    lowest = min(books, key=books.get)
    return highest, lowest

# 3️⃣ Count members who have not borrowed any books
def count_members_with_zero_borrows(members):
    count = sum(1 for m in members.values() if m == 0)
    return count

# 4️⃣ Display the most frequently borrowed book (mode of borrow counts)
from statistics import multimode

def most_frequent_borrowed_book(books):
    borrow_counts = list(books.values())
    mode_counts = multimode(borrow_counts)
    # find books with these mode counts
    most_frequent_books = [book for book, count in books.items() if count in mode_counts]
    return most_frequent_books

# -----------------------------
# Driver Code
# -----------------------------
print("Average number of books borrowed by members:", average_books_borrowed(members))

highest, lowest = highest_and_lowest_borrowed(books)
print(f"Most borrowed book: {highest}")
print(f"Least borrowed book: {lowest}")

print("Number of members who borrowed 0 books:", count_members_with_zero_borrows(members))

print("Most frequently borrowed books:", most_frequent_borrowed_book(books))
