#pragma warning(disable: 4996)
#include<stdio.h>

int main(void)
{
	int n;
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
	{
		char str[1001];
		scanf("%s", str);
		printf("%c%c\n",str[0], str[strlen(str)-1]);
	}
	return 0;
}
