@echo "Pulling repo..."
git fetch
git pull

@echo "Pulling submodules..."
cd src\main\java\com\lance5057\extradelight\tags
git fetch
git pull

pause