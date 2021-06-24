'''
Write a program to perform a basic ‘Ceaser’ encryption and decryption on text.
This algorithm works by moving letters along by an
‘offset’. If the offset is 2 then b —> d, h—>j etc.
Try to write two functions—One called ‘encrypt’ and one called
’decrypt’. Both will return a string.
The user selects whether the wish to encrypt or decrypt.
The user enters sentence to encrypt and the encryption adjust (i.e.
How many we move the letters along—this is a smallish integer)
The program responds with the encrypted or decrypted version
Algorithm for encryption
Type in text
Type in encryption adjust

Display Encrypt(text, adjust)
function Encrypt(text,adjust)
For each letter in text
Get its ascii code
Add the adjust to the ascii code
Turn this new ascii code back to a character
Append character to ciphertext string
End for
return ciphertext
end 

The Ceaser algorithms may have fooled the Gauls but it doesn't
take a genius to crack. So a much better algorithm would be one
that has a different offset for every letter. We can do this using the
random number generator—because it generates the same sequence of random numbers from a ‘seed’ position. As long as
sender and receiver agree where to ‘seed’ (this will be the encryption adjust) they can both work out the same offsets.
Algorithm for encrypt function

function Encrypt(text, adjust)
Randomize(adjust)
For each letter in text
Get its ascii code
Add random offset int(rnd()*10) to ascii code
Turn this new ascii code back to a character
Append character to ciphertext string
End for
return ciphertext
end

Extension
Try to use a single function with
an extra parameter to indicate
whether the text is being encrypted or decrypted rather than
having two different functions. 

Program will encrypt the message and generate the key. With encrypted message and the key, message can be
decrypted to original version. 
'''
import random

job = str(input('Do you want to encrypt or decrypt your message? '))
message = str(input('Enter your message here. '))

# Test Case
# job = 'e'
# message = 'Test message to encrypt and decrypt.'
# message = ['X', 'j', 'x', 'y', '!', 'o', 'j', 'w', 't', 'd', 'l', 'h', '$', 'y', 's', '%', 'i', 'r', 'f', 's', '~', 'r', 'u', '"', 'f', 'p', 'f', '!', 'i', 'f', 'd', 't', 'z', 'u', 'u', '/']
# key= [4, 5, 5, 5, 1, 2, 5, 4, 1, 3, 5, 3, 4, 5, 4, 5, 4, 4, 3, 1, 5, 2, 1, 2, 5, 2, 2, 1, 5, 1, 1, 2, 1, 5, 1, 1]


def encryption_tool(text: str):
    encrypted_message = []
    key = []
    if job.lower() == 'encrypt' or job.lower() == 'e':
        for letter in text:
            adjust = random.randint(1, 5)
            key.append(adjust)
            x = ord(letter) + adjust
            y = chr(x)
            encrypted_message.append(y)
        print('Ciphertext:', encrypted_message)
        # print(key)
    elif job.lower() == 'decrypt' or job.lower() == 'd':
        decrypted = []
        process = []
        decrypting = []
        key = list(input('Enter they key to read original message.'))
        for char in text:
            x = ord(char)
            process.append(x)
            l = [i - j for i, j in zip(process, key)]
            decrypting.append(l)

        decrypting = list(map(str, decrypting[-1]))   
        for item in decrypting:
            x = chr(int(item))
            decrypted.append(x)
        
        decrypted_message = ''
        for x in decrypted:
            decrypted_message += x
        
        print('Decrypted message:', decrypted_message)

    else:
        print('No right option choosen.')


encryption_tool(message)
