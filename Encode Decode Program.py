#This program will take an input string with the keycode, "crypt", and encode it with a random computer generated offset.
#The program will then work to decode the encrypted message. 
import random

#function to encode the user inputted message by randomlly inserting 1-3 "junk" characters in between each letter in the code
def encode(message):
    offset = random.randint(1,25)
    encoded_message = ""
    num = 0
    while num < len(message):
        if ord(message[num]) == 32:
            num += 1
        else:
            junk_characters = random.randint(1,3)
            for number in range (junk_characters):
                encoded_message += chr(random.randint(33,64))
            if ord(message[num]) + offset > 122:
                encoded_message += chr(ord(message[num]) + offset - 26)
            else:
                encoded_message += chr(ord(message[num]) + offset)
            num += 1
    return encoded_message
    
#function to strip the encoded message of special characters
def strip(mes):
    num = 0
    stripped_code = ""
    while num < len(mes):
        if 97 <= ord(mes[num]) <= 122:
            stripped_code += mes[num]
        num += 1
    return stripped_code

#fucntion to decode the stripped encrypted message by testing different computer generated offsets and searching for the keycode, "crypt"
def decode(stripped_mess):
    code_key = "crypt"
    find_offset = 0
    decoded_message = ""
    while code_key not in decoded_message:
        numb = 0
        decoded_message = ""
        while numb < len(stripped_mess):
            if ord(stripped_mess[numb])- find_offset < 97:
               decoded_message += chr(ord(stripped_mess[numb]) + (26 - find_offset))
            else:
                decoded_message += chr(ord(stripped_mess[numb]) - find_offset)
            numb += 1
        find_offset += 1
    print ("The offset was", find_offset - 1)
    return decoded_message

#main section begins here

print ("This program encodes a message using junk characters and a random computer gererated offset. 
print ("The program will then reduce and decodes the ecnrypted message")
print ("Please enter a message you would like encoded with the embedded key code")
message = input("Enter message here: ")

#will first turn all characters to lowercase
message = message.lower()

#calls the encode function to utilize the computer offset and insert random junk chacters
encoded = encode(message)
print ("Lower case encoded message is: ", encoded)

#will call the function to strip the encoded string of its junk characters
reduced_encoded = strip(encoded)
print ("With the special characters stripped out the message is", reduced_encoded)

#will call the decode function to return the decoded string back to user
decoded = decode(reduced_encoded)
print ("The decoded message is", decoded)
