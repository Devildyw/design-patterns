package hungrysingleton

import (
	"sync"
	"testing"
)

var wg sync.WaitGroup

func TestHungrySingleton(t *testing.T) {
	wg.Add(30)
	for i := 0; i < 30; i++ {
		go func() {
			GetInstance().Work()
			wg.Done()
		}()
	}
	wg.Wait()
}
