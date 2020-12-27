#include <iostream.h>
void strcpy(char *dest, char *src)
{
    do
        *dest++ = *src++;
    while (*src);
}
int strlen(char *s)
{
    int n = 0;
    while (*s)
    {
        n++;
        s++;
    }
    return n;
}
main()
{
    char si[] = “texto”;
    char so[80];
    cout << strlen(si);
    strcpy(so,si);
    cout << so;
}