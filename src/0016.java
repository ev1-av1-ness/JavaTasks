/**
 * Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.
 * 
 * Контрольная сумма данных вычисляется по следующему алгоритму:
 * 
 *     Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
 *     Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле: Cn+1=rotateLeft(Cn) xor bn+1
 * 
 * , где Cn — контрольная сумма первых n байт данных, rotateLeft — циклический сдвиг бит числа на один бит влево (чтобы не изобретать велосипед, используйте Integer.rotateLeft), bn
 * 
 *     — n-ный байт данных.
 * 
 * Поскольку метод не открывал данный InputStream, то и закрывать его он не должен. Выброшенное из методов InputStream исключение должно выбрасываться из метода.
 */
 public static int checkSumOfStream(InputStream inputStream) throws IOException {
    int result = 0;
    int n = inputStream.read();
    while(n > -1) {
        result = Integer.rotateLeft(result, 1) ^ n;
        n = inputStream.read();
    }
    return result;
}