#include<stdio.h>

int main() {
	int i;
	int max = 0;
	int arr[9];
	int n = 0;

	for (i = 1; i <= 9; i++) {
		scanf("%d", &arr[i]);
		if (arr[i]<100)
		{
			if (arr[i]>max)	
			{
				max = arr[i];
				n = i;
			}
		}
	}

	printf("%d\n", max);
	printf("%d\n", n);

	return 0;
}
