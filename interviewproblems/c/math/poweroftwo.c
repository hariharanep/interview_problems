#include <stdio.h>
#include <stdlib.h>

int main (int argc, char *argv[]) {

	if (argc < 2) {
	   fprintf (stdout, "Usave poweroftwo <num>\n") ;
	}


	int num = atoi(argv[1]) ;

	if ((num & (num-1)) == 0) {
 	  fprintf (stdout, "yes %d is a power of two \n", num) ;
	}
	else {
 	  fprintf (stdout, "no %d is not a power of two \n", num) ;
	}


}

