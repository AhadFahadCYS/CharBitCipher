# 🔐 CharBitCipher

## 📖 Overview
This project implements a novel cryptographic algorithm that combines **character-oriented** and **bit-oriented** operations using **two user-provided keys**:

- **Key₁ (integer):** used in a Caesar-style shift equation over A–Z (A=0, B=1, …, Z=25).  
- **Key₂ (string):** must be the same length as the plaintext, rotated left by one position, converted to binary, and then used in an XOR operation.

This dual-key approach increases complexity and strengthens protection against modern cyber threats.

---

## 🔑 Encryption Process
1. **Shift Cipher (Key₁):**  
   - For each plaintext letter `P` (0–25), compute:  
     ```
     C1 = (P + Key₁) mod 26
     ```
   - Convert the result back to letters → this gives **cipher1**.  
   - Convert **cipher1** to binary (8-bit ASCII).

2. **Key₂ Preparation:**  
   - Take user input **Key₂** (same length as plaintext).  
   - Rotate left once.  
   - Convert to binary.

3. **XOR Operation:**  
   - XOR `cipher1 (binary)` with `key2_rot (binary)` → final **ciphertext**.  
   - Store/transmit ciphertext in **Hex** or **Base64** encoding.

---

## 🛠️ Technologies
- **Language:** Java  
- **IDE:** NetBeans  

---

## 👥 Team Members
- Maha Almujalli
- Ahad Alotaibi
- Reema Alosaimi
- Aljoharah Alquhtani
