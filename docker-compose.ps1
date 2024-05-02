
$Host.UI.RawUI.WindowTitle = "Start services"

& {
    $composeList = (Get-ChildItem -LiteralPath $PSScriptRoot -Filter *.yml).FullName -join ' -f '
    Invoke-Expression "docker-compose -p case-study -f $composeList up -d"
}