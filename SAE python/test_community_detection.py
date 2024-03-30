# Make your tests here

def test_get_people():
    reseau = {
    "Alice" : ["Bob", "Dominique"],
    "Bob" : ["Alice", "Charlie", "Dominique"],
    "Charlie" : ["Bob"],
    "Dominique" : ["Alice", "Bob"]
    }
    assert get_people(reseau) ==  ["Alice", "Bob", "Charlie", "Dominique"]
    print("Le test de la fonction get_people : OK !!!!")
test_get_people()

def test_are_friends():
    reseau = {
    "Alice" : ["Bob", "Dominique"],
    "Bob" : ["Alice", "Charlie", "Dominique"],
    "Charlie" : ["Bob"],
    "Dominique" : ["Alice", "Bob"]
    }
    assert are_friends(reseau,"Alice","Bob") ==  True
    assert are_friends(reseau,"Alice","Charlie") ==  False
    print("Le test de la fonction are_friends : OK !!!!")
test_get_people()

def test_all_his_friends():
    reseau = {
    "Alice" : ["Bob", "Dominique"],
    "Bob" : ["Alice", "Charlie", "Dominique"],
    "Charlie" : ["Bob"],
    "Dominique" : ["Alice", "Bob"]
    }
    assert all_his_friends(reseau,"Alice",["Bob", "Dominique"]) ==  True
    assert all_his_friends(reseau,"Alice",["Bob", "Charlie"]) ==  False
    print("Le test de la fonction all_his_friends : OK !!!!")
test_get_people()

def test_is_a_community():
    reseau = {
    "Alice" : ["Bob", "Dominique"],
    "Bob" : ["Alice", "Charlie", "Dominique"],
    "Charlie" : ["Bob"],
    "Dominique" : ["Alice", "Bob"]
    }
    assert is_a_community(reseau,["Alice", "Bob", "Dominique"]) == True
    assert is_a_community(reseau,["Alice", "Bob", "Charlie"]) == False
    print("Le test de la fonction is_a_community : OK!!!")
test_is_a_community()

def test_find_community():
    reseau = {
    "Alice" : ["Bob", "Dominique"],
    "Bob" : ["Alice", "Charlie", "Dominique"],
    "Charlie" : ["Bob"],
    "Dominique" : ["Alice", "Bob"]
    }
    assert find_community(reseau,["Alice", "Bob", "Charlie", "Dominique"]) == ["Alice", "Bob", "Dominique"]
    assert find_community(reseau,["Charlie", "Alice", "Bob", "Dominique"]) == ["Charlie", "Bob"]
    assert find_community(reseau,["Charlie", "Alice", "Dominique"]) == ["Charlie"]
    print("Le teste de la fonction find_community : OK!!!!")
test_find_community()

def test_order_by_decreasing_popularity():
    reseau = {
    "Alice" : ["Bob", "Dominique"],
    "Bob" : ["Alice", "Charlie", "Dominique"],
    "Charlie" : ["Bob"],
    "Dominique" : ["Alice", "Bob"]
    }
    assert order_by_decreasing_popularity(reseau,["Alice", "Bob", "Charlie"]) == ["Bob", "Alice", "Charlie"]
    print("Le teste de la fonction find_community : OK!!!!")
test_order_by_decreasing_popularity()

def test_find_community_by_decreasing_popularity():
    reseau = {
    "Alice" : ["Bob", "Dominique"],
    "Bob" : ["Alice", "Charlie", "Dominique"],
    "Charlie" : ["Bob"],
    "Dominique" : ["Alice", "Bob"]
    }
    assert find_community_by_decreasing_popularity(reseau) == ["Bob", "Alice", "Dominique"]
    print("Le teste de la fonction find_community : OK!!!!")
test_find_community_by_decreasing_popularity()

def test_find_community_from_person():
    reseau = {
    "Alice" : ["Bob", "Dominique"],
    "Bob" : ["Alice", "Charlie", "Dominique"],
    "Charlie" : ["Bob"],
    "Dominique" : ["Alice", "Bob"]
    }
    assert find_community_from_person(reseau, "Alice") == ["Alice", "Bob", "Dominique"]
    assert find_community_from_person(reseau, "Charlie") == ["Charlie", "Bob"]
    print("Le test de la fonction find_community_from_person : OK!!!!")

test_find_community_from_person()

def test_find_max_community():
    reseau = {
    "Alice" : ["Bob", "Dominique"],
    "Bob" : ["Alice", "Charlie", "Dominique"],
    "Charlie" : ["Bob"],
    "Dominique" : ["Alice", "Bob"]
    }
    assert find_max_community(reseau) == ["Alice", "Bob", "Dominique"]
    print("Le teste de la fonction find_max_community : OK!!!")
test_find_max_community()

